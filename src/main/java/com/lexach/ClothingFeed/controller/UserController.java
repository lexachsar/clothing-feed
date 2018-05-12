package com.lexach.ClothingFeed.controller;

import com.lexach.ClothingFeed.exception.RescourceNotFoundException;
import com.lexach.ClothingFeed.model.User;
import com.lexach.ClothingFeed.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.hibernate.internal.util.collections.ArrayHelper.toList;

// Комбинация аннотаций:
//  @Controller -- определяет контроллер
//  @ResponseBody -- отмечает, что возвращаемые методами значения должны быть использованы в ответе на запрос.
@RestController
// Определяет, что url для всех api этого контроллера будут начинаться с "/api"
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository userRepository;

    // Вывести всех юзеров (GET /api/users)
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return toList( userRepository.findAll() );
    }

    // Создать нового юзера (POST /api/users)
    @PostMapping("/users")
    // @Valid -- удостоверяется в том, что тело запроса валидно
    // @RequestBody -- привязывает к телу запроса параметры метода
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    // Достать одного юзера (GET /api/users/{userId})
    @GetMapping("/users/{id}")
    // @PathVariable -- Связывает переменную пути с параметром метода
    public User getUserById(@PathVariable(value = "id") Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RescourceNotFoundException("User", "id", userId));
    }

    // Обновить одного юзера (PUT /api/users/{userId})
    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable(value = "id") Long userId, @Valid @RequestBody User userDetails){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RescourceNotFoundException("User", "id", userId));

        user.setGender(userDetails.getGender());
        user.setIdCountry(userDetails.getIdCountry());

        User updatedUser = userRepository.save(user);

        return updatedUser;
    }

    // Удалить одного юзера (DELETE /api/users/{userId})
    @DeleteMapping("/users/id")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RescourceNotFoundException("User", "id", userId));

        userRepository.delete(user);

        return ResponseEntity.ok().build();
    }

}
