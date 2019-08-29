package com.pinakis.spring;


import java.util.ArrayList;
import java.util.List;

/**
 * The State Enum.
 */
public enum State {
    /**
     * DRAFT.
     */
    DRAFT("Draft"){
        @Override
        public List<State> getNextStates(boolean isPublished) {
            List<State> nextStates = new ArrayList<>();
            nextStates.add(State.PUBLISHED);
            nextStates.add(State.ARCHIVED);
            nextStates.add(State.IN_REVIEW);
            return nextStates;
        }
    },
    /**
     * IN_REVIEW.
     */
    IN_REVIEW("In Review") {
        @Override
        public List<State> getNextStates(boolean isPublished) {
            List<State> nextStates = new ArrayList<>();
            nextStates.add(State.PUBLISHED);
            nextStates.add(State.ARCHIVED);
            if (isPublished) {
                nextStates.add(State.UPDATED);
            } else {
                nextStates.add(State.DRAFT);
            }
            return nextStates;
        }
    },
    /**
     * PUBLISHED.
     */
    PUBLISHED("Published") {
        @Override
        public List<State> getNextStates(boolean isPublished) {
            List<State> nextStates = new ArrayList<>();
            nextStates.add(State.UPDATED);
            nextStates.add(State.UNPUBLISHED);
            return nextStates;
        }
    },
    /**
     * ARCHIVED.
     */
    ARCHIVED("Archived") {
        @Override
        public List<State> getNextStates(boolean isPublished) {
            List<State> nextStates = new ArrayList<>();
            if (isPublished) {
                nextStates.add(State.IN_REVIEW);
            } else {
                nextStates.add(State.DRAFT);
            }
            return nextStates;
        }
    },
    /**
     * UPDATED.
     */
    UPDATED("Updated") {
        @Override
        public List<State> getNextStates(boolean isPublished) {
            List<State> nextStates = new ArrayList<>();
            nextStates.add(State.PUBLISHED);
            nextStates.add(State.IN_REVIEW);
            return nextStates;
        }
    },
    /**
     * UNPUBLISHED.
     */
    UNPUBLISHED("Unpublished") {
        @Override
        public List<State> getNextStates(boolean isPublished) {
            List<State> nextStates = new ArrayList<>();
            nextStates.add(State.ARCHIVED);
            nextStates.add(State.IN_REVIEW);
            nextStates.add(State.PUBLISHED);
            return nextStates;
        }
    };

    private final String stateLabel;

    /**
     * This initialize State with StateLabel.
     *
     * @param stateLabel stateLabel.
     */
    State(String stateLabel) {
        this.stateLabel = stateLabel;
    }

    public String getStateLabel() {
        return this.stateLabel;
    }

    /**
     *  This method return the nextState.
     * @param isPublished Article is already published or not.
     * @return  List of next State.
     */
    public abstract List<State> getNextStates(boolean isPublished);

}
