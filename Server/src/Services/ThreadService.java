package Services;

import Models.Human;
import Models.Student;
import Models.Teacher;

import java.io.*;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;

public class ThreadService implements Runnable{
    private Socket clientPipeline;
    private BufferedReader ois = null;
    private ArrayList<Human> people;

    public ThreadService(Socket clientPipeline){
        this.clientPipeline = clientPipeline;
        this.people = new ArrayList<>();
    }
    @Override
    public void run() {
        try {
            ois = new BufferedReader(
                    new InputStreamReader(
                            clientPipeline.getInputStream()));

            String message;
            while ((message = ois.readLine()) != null) {
                System.out.println(message);
                // output the sorted collection of Human by age.
                if(message.equals("exit")) {
                    Collections.sort(people);
                    for(int i=0;i<people.size();i++)
                    {
                        System.out.println(people.get(i).toString());
                    }
                    return;
                }
                String[] splitted = message.split("\\s+");
                if (splitted[0].equals("Student")) {
                    Human student = new Student(
                            splitted[1],
                            splitted[2],
                            splitted[3],
                            Integer.parseInt(splitted[4]),
                            Integer.parseInt(splitted[5]));
                    people.add(student);
                } else {
                    Human teacher = new Teacher(
                            splitted[1],
                            splitted[2],
                            splitted[3],
                            Integer.parseInt(splitted[4]),
                            splitted[5]);
                    people.add(teacher);
                }
            }
            try {
                clientPipeline.close();
                ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
