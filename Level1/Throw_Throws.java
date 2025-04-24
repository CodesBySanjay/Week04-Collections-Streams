class UserAlreadyExistsException extends Exception {
    UserAlreadyExistsException(String msg) {
        super(msg);
    }
}

class UserNotFoundException extends Exception {
    UserNotFoundException(String msg) {
        super(msg);
    }
}

class UserService {
    boolean exists(String user) {
        return user.equals("sanjay");
    }

    void registerUser(String user) throws UserAlreadyExistsException {
        if (exists(user)) {
            throw new UserAlreadyExistsException("User already exists: " + user);
        }
        System.out.println("User registered: " + user);
    }

    void checkUserExistence(String user) throws UserNotFoundException {
        if (!exists(user)) {
            throw new UserNotFoundException("User not found: " + user);
        }
        System.out.println("User exists: " + user);
    }

    public static void main(String[] args) {
        UserService us = new UserService();
        try {
            us.registerUser("sanjay");
        } catch (UserAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        try {
            us.checkUserExistence("alex");
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
