package ru.emelyanovkonstantin.springsecurity.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.emelyanovkonstantin.springsecurity.model.User;
import ru.emelyanovkonstantin.springsecurity.service.UserService;

/**
 * Created by EmelyanovKonstantin on 01.07.2020
 *
 * implements {@link org.springframework.validation.Validator}
 * @version 1.0
 */
@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"username","Require");
        if(user.getUsername().length() < 6 ||  user.getUsername().length() >32){
            errors.rejectValue("username", "Size.userForm.username");
        }

        if(userService.findByUsername(user.getUsername()) != null){
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password", "Required");
        if(user.getPassword().length() < 6 || user.getPassword().length() > 32){
            errors.rejectValue("password","Size.userForm.password");
        }

        if(!user.getConfirmPassword().equals(user.getPassword())){
            errors.rejectValue("ConfirmPassword","Different.userForm.password");
        }

    }
}
