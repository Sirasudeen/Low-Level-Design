package Memento;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ResumeEditor editor = new ResumeEditor();
        ResumeHistory history = new ResumeHistory();

        editor.setName("Siras");
        editor.setEducation("B.Tech CSE");
        editor.setExperience("Fresher");
        editor.setSkills(Arrays.asList("Java", "DSA"));
        history.save(editor);

        editor.setExperience("SDE Intern at YBI Foundations");
        editor.setSkills(Arrays.asList("Java", "DSA", "LLD", "Spring Boot"));
        history.save(editor);

        editor.printResume();
        System.out.println("");
        
        history.undo(editor);
        editor.printResume(); 
        System.out.println("");

        history.undo(editor);
        editor.printResume(); 
    }
}
