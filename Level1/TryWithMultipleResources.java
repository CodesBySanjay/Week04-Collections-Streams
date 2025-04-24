class InvalidAgeException extends Exception {
    InvalidAgeException(String msg) {
        super(msg);
    }
}

class Voter {
    void checkEligibility(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Not eligible to vote: " + age);
        }
        System.out.println("Eligible to vote: " + age);
    }

    public static void main(String[] args) {
        Voter v = new Voter();
        try {
            v.checkEligibility(16);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
    }
}