package validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import spring.soa.web.entity.User;
import spring.soa.web.service.UserService;
@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "This field is required");
        if (user.getUserName().length() < 2 || user.getUserName().length() > 100) {
            errors.rejectValue("username", "Username must be between 2 and 100 characters.");
        }

        if (userService.findByUserName(user.getUserName()) != null) {
           errors.rejectValue("username ", "Such username already exists.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "This field is required");

        if (user.getPassword().length() < 2 || user.getPassword().length() > 100) {
            errors.rejectValue("password", "Password must be over 8 characters");
        }

        if (user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Password don't match.");
        }
    }
}

