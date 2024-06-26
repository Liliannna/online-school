package net.online.school.ttschool;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class TestTraineeQueue {

    @Test
    public void testTraineeQueue() throws TrainingException {
        Trainee trainee1 = new Trainee("Иван", "Иванов", 1);
        Trainee trainee2 = new Trainee("Петр", "Петров", 3);
        Trainee trainee3 = new Trainee("Николай", "Николаев", 4);
        TraineeQueue traineeQueue = new TraineeQueue();
        traineeQueue.addTrainee(trainee1);
        traineeQueue.addTrainee(trainee2);
        traineeQueue.addTrainee(trainee3);
        Trainee traineeFromQueue1 = traineeQueue.removeTrainee();
        assertEquals(trainee1, traineeFromQueue1);
        Trainee traineeFromQueue2 = traineeQueue.removeTrainee();
        assertEquals(trainee2, traineeFromQueue2);
        Trainee traineeFromQueue3 = traineeQueue.removeTrainee();
        assertEquals(trainee3, traineeFromQueue3);
        Trainee trainee = null;
        try {
            trainee = traineeQueue.removeTrainee();
            fail();
        } catch (TrainingException ex) {
            assertNull(trainee);
        }
    }
}
