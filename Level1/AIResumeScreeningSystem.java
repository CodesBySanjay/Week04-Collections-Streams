import java.util.List;
import java.util.ArrayList;

abstract class JobRole {
    private String roleName;

    public JobRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String roleName) {
        super(roleName);
    }
}

class DataScientist extends JobRole {
    public DataScientist(String roleName) {
        super(roleName);
    }
}

class ProductManager extends JobRole {
    public ProductManager(String roleName) {
        super(roleName);
    }
}

class Resume<T extends JobRole> {
    private String candidateName;
    private T jobRole;

    public Resume(String candidateName, T jobRole) {
        this.candidateName = candidateName;
        this.jobRole = jobRole;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public T getJobRole() {
        return jobRole;
    }
}

class ResumeScreeningSystem {
    public static void processResumes(List<? extends JobRole> roles) {
        for (JobRole role : roles) {
            System.out.println("Processing resume for: " + role.getRoleName());
        }
    }

    public static void main(String[] args) {
        Resume<SoftwareEngineer> r1 = new Resume<>("Alice", new SoftwareEngineer("Software Engineer"));
        Resume<DataScientist> r2 = new Resume<>("Bob", new DataScientist("Data Scientist"));
        Resume<ProductManager> r3 = new Resume<>("Carol", new ProductManager("Product Manager"));

        List<JobRole> roleList = new ArrayList<>();
        roleList.add(r1.getJobRole());
        roleList.add(r2.getJobRole());
        roleList.add(r3.getJobRole());

        processResumes(roleList);
    }
}
