package ch.heigvd.mcr.bridgehack;

import ch.heigvd.mcr.bridgehack.player.Player;
import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.awt.Font;

public class MapState extends BasicGameState {
    public static final int ID = 3;

    private Map map;
    private Player player;
    private String notification = "";
    private boolean attacking;
    private TrueTypeFont ttf;
    private boolean turnIsOver = false;
    private int turn = 0;
    private int counter = 0;

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        map = new Map();
        player = new Player(map,40, 56);
        Font font = new Font("Ubuntu Mono ", Font.PLAIN, 16);
        ttf = new TrueTypeFont(font, true);
        System.out.println("HELLO");
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) {
        graphics.setColor(org.newdawn.slick.Color.white);
        ttf.drawString(400, 660, Integer.toString(turn));
        ttf.drawString(0, 660, player.getStatus());

        if (!notification.equals("")) {
            ttf.drawString(550, 660, notification);
        }

        graphics.scale(2, 2);
        map.render(1);
        map.render(2);
        player.setName(((BridgeHack) stateBasedGame).getUsername());
        player.render(graphics);
        map.render(3);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) {
        if (!turnIsOver) {
            player.update(delta);

            if (counter++ >= 16) {
                turnIsOver = true;
                counter = 0;
                turn++;
                player.stop();
            }
        }
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void keyPressed(int key, char c) {
        if (turnIsOver) {
            switch (key) {
                case Input.KEY_UP: {
                    if (attacking) {
                        player.attack(0);
                        attacking = false;
                        notification = "";
                    } else {
                        player.move(0);
                    }

                    break;
                }
                case Input.KEY_LEFT: {
                    if (attacking) {
                        player.attack(1);
                        attacking = false;
                        notification = "";
                    } else {
                        player.move(1);
                    }

                    break;
                }
                case Input.KEY_DOWN: {
                    if (attacking) {
                        player.attack(2);
                        attacking = false;
                        notification = "";
                    } else {
                        player.move(2);
                    }

                    break;
                }
                case Input.KEY_RIGHT: {
                    if (attacking) {
                        player.attack(3);
                        attacking = false;
                        notification = "";
                    } else {
                        player.move(3);
                    }

                    break;
                }
                case Input.KEY_A: {
                    attacking = true;
                    notification = "Which direction ?";
                    return;
                }
            }
            turnIsOver = false;
        }
    }
}
