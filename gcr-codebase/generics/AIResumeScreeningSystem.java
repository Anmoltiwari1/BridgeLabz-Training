import java.util.*;

// Abstract base class for job roles
abstract class JobRole {
    String title;
    List<String> requiredSkills;
    int experienceYears;
    
    JobRole(String title, List<String> requiredSkills, int experienceYears) {
        this.title = title;
        this.requiredSkills = requiredSkills;
        this.experienceYears = experienceYears;
    }
    
    abstract double calculateMatchScore(List<String> candidateSkills, int candidateExperience);
    
    String getTitle() { return title; }
    List<String> getRequiredSkills() { return requiredSkills; }
    int getExperienceYears() { return experienceYears; }
}

class SoftwareEngineer extends JobRole {
    SoftwareEngineer() {
        super("Software Engineer", 
              Arrays.asList("Java", "Python", "SQL", "Git", "Algorithms"), 
              2);
    }
    
    double calculateMatchScore(List<String> candidateSkills, int candidateExperience) {
        double skillMatch = 0;
        for (String skill : requiredSkills) {
            if (candidateSkills.contains(skill)) skillMatch++;
        }
        
        double skillScore = (skillMatch / requiredSkills.size()) * 70;
        double expScore = Math.min(candidateExperience / (double) experienceYears, 1.0) * 30;
        
        return skillScore + expScore;
    }
}

class DataScientist extends JobRole {
    DataScientist() {
        super("Data Scientist", 
              Arrays.asList("Python", "R", "Machine Learning", "Statistics", "SQL"), 
              3);
    }
    
    double calculateMatchScore(List<String> candidateSkills, int candidateExperience) {
        double skillMatch = 0;
        for (String skill : requiredSkills) {
            if (candidateSkills.contains(skill)) skillMatch++;
        }
        
        double skillScore = (skillMatch / requiredSkills.size()) * 80;
        double expScore = Math.min(candidateExperience / (double) experienceYears, 1.0) * 20;
        
        return skillScore + expScore;
    }
}

class ProductManager extends JobRole {
    ProductManager() {
        super("Product Manager", 
              Arrays.asList("Strategy", "Analytics", "Communication", "Leadership", "Agile"), 
              4);
    }
    
    double calculateMatchScore(List<String> candidateSkills, int candidateExperience) {
        double skillMatch = 0;
        for (String skill : requiredSkills) {
            if (candidateSkills.contains(skill)) skillMatch++;
        }
        
        double skillScore = (skillMatch / requiredSkills.size()) * 60;
        double expScore = Math.min(candidateExperience / (double) experienceYears, 1.0) * 40;
        
        return skillScore + expScore;
    }
}

// Generic resume class with bounded type parameter
class Resume<T extends JobRole> {
    String candidateName;
    List<String> skills;
    int experience;
    T targetRole;
    double matchScore;
    
    Resume(String candidateName, List<String> skills, int experience, T targetRole) {
        this.candidateName = candidateName;
        this.skills = skills;
        this.experience = experience;
        this.targetRole = targetRole;
        this.matchScore = targetRole.calculateMatchScore(skills, experience);
    }
    
    String getCandidateName() { return candidateName; }
    List<String> getSkills() { return skills; }
    int getExperience() { return experience; }
    T getTargetRole() { return targetRole; }
    double getMatchScore() { return matchScore; }
    
    boolean isQualified() { return matchScore >= 60.0; }
    
    public String toString() {
        return candidateName + " -> " + targetRole.getTitle() + 
               " (Score: " + String.format("%.1f", matchScore) + "%)";
    }
}

public class AIResumeScreeningSystem {
    List<Resume<SoftwareEngineer>> softwareResumes = new ArrayList<>();
    List<Resume<DataScientist>> dataResumes = new ArrayList<>();
    List<Resume<ProductManager>> pmResumes = new ArrayList<>();
    
    // Generic method to add resume
    <T extends JobRole> void addResume(Resume<T> resume) {
        if (resume.getTargetRole() instanceof SoftwareEngineer) {
            softwareResumes.add((Resume<SoftwareEngineer>) resume);
        } else if (resume.getTargetRole() instanceof DataScientist) {
            dataResumes.add((Resume<DataScientist>) resume);
        } else if (resume.getTargetRole() instanceof ProductManager) {
            pmResumes.add((Resume<ProductManager>) resume);
        }
    }
    
    // Wildcard method to screen resumes regardless of job role
    void screenResumes(List<? extends Resume<? extends JobRole>> resumes, String roleName) {
        System.out.println("\n=== " + roleName + " Screening Results ===");
        
        List<Resume<? extends JobRole>> qualified = new ArrayList<>();
        List<Resume<? extends JobRole>> rejected = new ArrayList<>();
        
        for (Resume<? extends JobRole> resume : resumes) {
            if (resume.isQualified()) {
                qualified.add(resume);
            } else {
                rejected.add(resume);
            }
        }
        
        System.out.println("Qualified Candidates (" + qualified.size() + "):");
        qualified.sort((r1, r2) -> Double.compare(r2.getMatchScore(), r1.getMatchScore()));
        for (Resume<? extends JobRole> resume : qualified) {
            System.out.println("  ✓ " + resume);
        }
        
        System.out.println("Rejected Candidates (" + rejected.size() + "):");
        for (Resume<? extends JobRole> resume : rejected) {
            System.out.println("  ✗ " + resume);
        }
    }
    
    // Generic method to get top candidates
    <T extends JobRole> List<Resume<T>> getTopCandidates(List<Resume<T>> resumes, int count) {
        return resumes.stream()
                     .filter(Resume::isQualified)
                     .sorted((r1, r2) -> Double.compare(r2.getMatchScore(), r1.getMatchScore()))
                     .limit(count)
                     .collect(ArrayList::new, (list, item) -> list.add(item), (list1, list2) -> list1.addAll(list2));
    }
    
    void runScreeningProcess() {
        screenResumes(softwareResumes, "Software Engineer");
        screenResumes(dataResumes, "Data Scientist");
        screenResumes(pmResumes, "Product Manager");
        
        // Show top candidates for each role
        System.out.println("\n=== Top Candidates Summary ===");
        System.out.println("Top Software Engineers: " + getTopCandidates(softwareResumes, 2).size());
        System.out.println("Top Data Scientists: " + getTopCandidates(dataResumes, 2).size());
        System.out.println("Top Product Managers: " + getTopCandidates(pmResumes, 2).size());
    }
    
    public static void main(String[] args) {
        AIResumeScreeningSystem system = new AIResumeScreeningSystem();
        
        // Add Software Engineer resumes
        system.addResume(new Resume<>("Alice", Arrays.asList("Java", "Python", "SQL", "Git"), 3, new SoftwareEngineer()));
        system.addResume(new Resume<>("Bob", Arrays.asList("Java", "Git"), 1, new SoftwareEngineer()));
        system.addResume(new Resume<>("Charlie", Arrays.asList("Java", "Python", "SQL", "Git", "Algorithms"), 5, new SoftwareEngineer()));
        
        // Add Data Scientist resumes
        system.addResume(new Resume<>("Diana", Arrays.asList("Python", "R", "Machine Learning", "Statistics"), 4, new DataScientist()));
        system.addResume(new Resume<>("Eve", Arrays.asList("Python", "SQL"), 2, new DataScientist()));
        
        // Add Product Manager resumes
        system.addResume(new Resume<>("Frank", Arrays.asList("Strategy", "Analytics", "Communication", "Leadership"), 6, new ProductManager()));
        system.addResume(new Resume<>("Grace", Arrays.asList("Communication", "Agile"), 2, new ProductManager()));
        
        system.runScreeningProcess();
    }
}