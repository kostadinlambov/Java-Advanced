import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class p11_Students_Joined_to_Specialties {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<StudentSpeciality> students = new ArrayList<>();
        List<StudentSpeciality> studentsSpeciality = new ArrayList<>();

        while (true) {
            String[] line = reader.readLine().split("\\s+");
            if ("Students:".equalsIgnoreCase(line[0])) {
                break;
            }

            studentsSpeciality.add(new StudentSpeciality(line[0] + " " + line[1], line[2]));
        }
        while (true) {
            String[] line = reader.readLine().split("\\s+");
            if ("END".equalsIgnoreCase(line[0])) {
                break;
            }

            students.add(new StudentSpeciality(line[1] + " " + line[2], line[0]));
        }

        students.stream().sorted(Comparator.comparing(StudentSpeciality::getName))
                .forEach(st -> studentsSpeciality.stream()
                        .filter((spec) -> spec.getNumber().equalsIgnoreCase(st.getNumber()))
                        .forEach(speciality -> System.out.printf("%s %s %s\n",
                                st.getName(), st.getNumber(), speciality.getName())));
    }
}

class StudentSpeciality {

    private String name;
    private String number;

    StudentSpeciality(String _name, String numb) {
        this.setName(_name);
        this.setNumber(numb);
    }

    String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    String getNumber() {
        return this.number;
    }

    private void setNumber(String number) {
        this.number = number;
    }
}