package br.com.jjp.rockpaperscissors;

import br.com.rockpaperscissors.jjp.exceptions.NoSuchStrategyError;
import br.com.rockpaperscissors.jjp.exceptions.WrongNumberOfPlayersError;

/**
 * 
 * @author Jorge
 *
 */

public class Regras {
	
	/***
	 * Torneio continua até que haja apenas um único vencedor.
	 * @param tournament Confere jogadas numa lista
	 * @return Array de String Jogada e jogador vencedor
	 * @throws WrongNumberOfPlayersError Se o número de jogadores não for igual a 2 
	 * e se o formato não for Strinf[]
	 * @throws NoSuchStrategyError Se a estratégia de qualquer jogador for diferente de "R", "P" ou "S"
	 */
	
    public String[] rps_tournament_winner(Object[] tournament) throws WrongNumberOfPlayersError, NoSuchStrategyError {
        String[] vencedor = null;
        Object[] jogada = new Object[2];

        for (int indice = 0; indice <= 1; indice++) {
            if (tournament[indice] instanceof String[]) {
                jogada[indice] = (String[]) tournament[indice];
            } else if (tournament[indice] instanceof Object[]) {
                jogada[indice] = rps_tournament_winner((Object[]) tournament[indice]);
            }
        }

        vencedor = rps_game_winner(jogada);

        return vencedor;
    }
    
    /**
     * 
     * @param players array de jogadores e jogadas
     * @return Jogada e jogador vencedor
     * @throws WrongNumberOfPlayersError Se o número de jogadores não for igual a 2 
	 * e se o formato não for String[] 
     * @throws NoSuchStrategyError Se a estratégia de qualquer jogador for diferente de "R", "P" ou "S" 
     */

    public String[] rps_game_winner(Object[] players) throws WrongNumberOfPlayersError, NoSuchStrategyError {
        String[] vencedor = null;
        String[] jogador1;
        String[] jogador2;

        verificar(players);

        jogador1 = (String[]) players[0];
        jogador2 = (String[]) players[1];

        vencedor = jogador1;
        switch (jogador1[1].toUpperCase()) {
            case "R":
                if (jogador2[1].equalsIgnoreCase("P")) {
                    vencedor = jogador2;
                }
                break;

            case "S":
                if (jogador2[1].equalsIgnoreCase("R")) {
                    vencedor = jogador2;
                }
                break;

            case "P":
                if (jogador2[1].equalsIgnoreCase("S")) {
                    vencedor = jogador2;
                }
                break;
        }

        return vencedor;
    }
    
    /**
     * Verificar se array passado por parâmetro esta no padrão que o metodo espera
     * 
     * @param players Confere Array de objetos 
     * @throws WrongNumberOfPlayersError Se o número de jogadores não for igual a 2 
	 * e se o formato não for Strinf[]
     * @throws NoSuchStrategyError Se a estratégia de qualquer jogador for diferente de "R", "P" ou "S" 
     */

    private void verificar(Object[] players) throws WrongNumberOfPlayersError, NoSuchStrategyError {

        if (players.length != 2
                || !(players[0] instanceof String[])
                || !(players[1] instanceof String[])) {
            throw new WrongNumberOfPlayersError();
        }

        for (Object pseudoPlayer : players) {
            String[] player = (String[]) pseudoPlayer;
            if (player.length != 2
                    || !player[1].toUpperCase().matches("^[RPS]$")) {
                throw new NoSuchStrategyError();
            }
        }
    }
}

