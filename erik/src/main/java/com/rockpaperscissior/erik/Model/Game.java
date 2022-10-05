package com.rockpaperscissior.erik.Model;
import java.util.UUID;

/**
 * Representation of game
 */

public class Game {

        private UUID gameID;
        private State gameState;
        private State player1State;
        private State player2State;
        private Player player1;
        private Player player2;




        public Game(State gameState) {

                this.gameID = generateUUID();
                this.gameState = gameState;
        }

        public UUID generateUUID() {
                return UUID.randomUUID();
        }

        public UUID getGameID() {
                return gameID;
        }

        public void setPlayer1(Player player1) {
                this.player1 = player1;
        }

        public void setPlayer2(Player player2) {
                this.player2 = player2;
        }
        public void setGameState(State gameState) {
              this.gameState = gameState;
        }

        public State getGameState() {
                return gameState;
        }



        /**
         * Creates a String representation of the current game state
         * @return String representation of the current game state
         */
        @Override
        public String toString() {


                return "GameId: " + gameID +
                        "\nGame state: " + gameState +
                        "\nPlayer 1: " + player1.getName() +
                        "\nPlayer 1 State: " + player1.getState() +
                        "\nPlayer 1 move: " + player1.getMove() +
                        "\nPlayer 2: " + player2.getName() +
                        "\nPlayer 2 State: " + player2.getState() +
                        "\nPlayer 2 move: " + player2.getMove() +
                        "\nRESULT: " + "Player 1 - " + player1.getResult() + ", Player 2 - " + player2.getResult() + "\n";
        }
        public void hasPlayersMadeMoves(Player player1, Player player2){
                if (player1.getMove() != Move.DEFAULT){
                        player1.setState(State.ENDED);
                }
                if (player2.getMove() != Move.DEFAULT){
                        player2.setState(State.ENDED);
                }
        }
        /**
         * Evaluates the moves of both players
         * @param player1
         * @param player2
         */
        public void evaluateMoves(Player player1, Player player2) {

                if (player1.getMove().equals(player2.getMove())) {
                        player1.setResult(Result.DRAW);
                        player2.setResult(Result.DRAW);
                }
                else if (player1.getMove() == Move.DEFAULT || player2.getMove() == Move.DEFAULT) {
                        player1.setResult(Result.WAITING);
                        player2.setResult(Result.WAITING);
                }

                else if (player1.getMove().winsOver(player2.getMove())) {
                        player1.setResult(Result.WIN);
                        player2.setResult(Result.LOSE);
                }
                else if (player2.getMove().winsOver(player1.getMove())) {
                        player2.setResult(Result.WIN);
                        player1.setResult(Result.LOSE);
                }
        }
        public void evaluateAndSetGameState(){
                if (player1.getState() == State.ENDED && player2.getState() == State.ENDED){
                        gameState = State.ENDED;
                }
                else
                        gameState = State.ONGOING;

        }
}
