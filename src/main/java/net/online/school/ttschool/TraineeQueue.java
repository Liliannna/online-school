package net.online.school.ttschool;

import java.util.LinkedList;
import java.util.Queue;

public class TraineeQueue {

    private Queue<Trainee> queue;

    public TraineeQueue() {
        queue = new LinkedList<>();
    }

    public void addTrainee(Trainee trainee) {
        queue.add(trainee);
    }

    public Trainee removeTrainee() throws TrainingException {
        Trainee trainee = queue.peek();
        if (trainee == null) {
            throw new TrainingException(TrainingErrorCode.EMPTY_TRAINEE_QUEUE);
        }
        queue.remove();
        return trainee;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
