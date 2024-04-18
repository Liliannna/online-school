package net.online.school.ttschool;

import java.util.*;

public class School {
    private String name;
    private int year;
    private Set<Group> groups;

    public School(String name, int year) throws TrainingException {
        setName(name);
        setYear(year);
        groups = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws TrainingException {
        if (name == null || name.equals("")) {
            throw new TrainingException(TrainingErrorCode.SCHOOL_WRONG_NAME);
        }
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void addGroup(Group group) throws TrainingException {
        if(groups.contains(group)){
            throw new TrainingException(TrainingErrorCode.DUPLICATE_GROUP_NAME);
        }
        groups.add(group);
    }

    public void removeGroup(Group group) throws TrainingException {
        if (!groups.remove(group)) {
            throw new TrainingException(TrainingErrorCode.GROUP_NOT_FOUND);
        }
    }

    public void removeGroup(String name) throws TrainingException {
        for (Group group : groups) {
            if (group.getName().equals(name)) {
                groups.remove(group);
                return;
            }
        }
        throw new TrainingException(TrainingErrorCode.GROUP_NOT_FOUND);
    }

    public boolean containsGroup(Group group) {
        return groups.contains(group);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        School school = (School) o;

        if (year != school.year) return false;
        if (name != null ? !name.equals(school.name) : school.name != null) return false;
        return groups != null ? groups.equals(school.groups) : school.groups == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + year;
        result = 31 * result + (groups != null ? groups.hashCode() : 0);
        return result;
    }
}
