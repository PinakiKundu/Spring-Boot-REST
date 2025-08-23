package com.pinakis.spring;

import java.util.List;

/**
 * The State Enum.
 */
public enum State {
    DRAFT("Draft") {
        @Override
        public List<State> getNextStates(boolean isPublished) {
            return List.of(PUBLISHED, ARCHIVED, IN_REVIEW);
        }
    },
    IN_REVIEW("In Review") {
        @Override
        public List<State> getNextStates(boolean isPublished) {
            return isPublished
                    ? List.of(PUBLISHED, ARCHIVED, UPDATED)
                    : List.of(PUBLISHED, ARCHIVED, DRAFT);
        }
    },
    PUBLISHED("Published") {
        @Override
        public List<State> getNextStates(boolean isPublished) {
            return List.of(UPDATED, UNPUBLISHED);
        }
    },
    ARCHIVED("Archived") {
        @Override
        public List<State> getNextStates(boolean isPublished) {
            return isPublished ? List.of(IN_REVIEW) : List.of(DRAFT);
        }
    },
    UPDATED("Updated") {
        @Override
        public List<State> getNextStates(boolean isPublished) {
            return List.of(PUBLISHED, IN_REVIEW);
        }
    },
    UNPUBLISHED("Unpublished") {
        @Override
        public List<State> getNextStates(boolean isPublished) {
            return List.of(ARCHIVED, IN_REVIEW, PUBLISHED);
        }
    },
    UNKNOWN("Unknown") {
        @Override
        public List<State> getNextStates(boolean isPublished) {
            return List.of(DRAFT);
        }
    };

    private final String stateLabel;

    State(String stateLabel) {
        this.stateLabel = stateLabel;
    }

    public String getStateLabel() {
        return stateLabel;
    }

    public abstract List<State> getNextStates(boolean isPublished);
}
