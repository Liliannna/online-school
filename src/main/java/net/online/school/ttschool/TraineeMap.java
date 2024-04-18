package net.online.school.ttschool;

import java.util.*;
import java.util.Set;

public class TraineeMap {

    private Map<Trainee, String> traineeMap;

    public TraineeMap() {
        traineeMap = new HashMap<>();
    }

    public void addTraineeInfo(Trainee trainee, String institute) throws TrainingException {
        if (traineeMap.containsKey(trainee)) {
            throw new TrainingException(TrainingErrorCode.DUPLICATE_TRAINEE);
        }
        traineeMap.put(trainee, institute);
    }

    public void replaceTraineeInfo(Trainee trainee, String institute) throws TrainingException {
        if (!traineeMap.containsKey(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        traineeMap.put(trainee, institute);
    }

    public void removeTraineeInfo(Trainee trainee) throws TrainingException {
        if (!traineeMap.containsKey(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        traineeMap.remove(trainee);
    }

    public int getTraineesCount() {
        return traineeMap.size();
    }

    public String getInstituteByTrainee(Trainee trainee) throws TrainingException {
        if (traineeMap.containsKey(trainee)) {
            return traineeMap.get(trainee);
        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public Set<Trainee> getAllTrainees() {
        return traineeMap.keySet();
    }

    public Set<String> getAllInstitutes() {
        return new HashSet<>(traineeMap.values());
    }

    public boolean isAnyFromInstitute(String institute) {
        return traineeMap.containsValue(institute);
    }
}
