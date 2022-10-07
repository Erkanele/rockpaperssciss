package com.rockpaperscissior.erik.Model;

import java.util.Arrays;

/**
 * Enum class that holds the different states in the game.
 */

public enum State {

        STARTED("STARTED"),
        ONGOING("ONGOING"),
        ENDED("ENDED");

        private final String label;

        State(String label) {

                this.label = label;
        }
        /**
         * Method to set a state to ONGOING when a player has joined a game so not any NPE is thrown.
         */
        public static State defaultState(String stringToMatch) {
                return Arrays.stream(State.values()).filter(aEnum -> aEnum.label.equals(stringToMatch)).findFirst().orElse(State.STARTED);
        }
}
