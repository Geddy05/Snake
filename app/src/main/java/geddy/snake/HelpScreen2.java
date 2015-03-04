package geddy.snake;

import java.util.List;

import geddy.snake.framework.Game;
import geddy.snake.framework.Graphics;
import geddy.snake.framework.Input;
import geddy.snake.framework.Screen;

/**
 * Created by geddyS on 27-2-2015.
 */
public class HelpScreen2 extends Screen {
    public HelpScreen2(Game game){
        super(game);
    }

    @Override
    public void update(float deltaTime){
        List<Input.TouchEvent> touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();

        int len = touchEvents.size();
        for(int i =0; i <len; i++){
            Input.TouchEvent event = touchEvents.get(i);
            if(event.type == Input.TouchEvent.TOUCH_UP){
                if(event.x > 256 && event.y > 416){
                    game.setScreen(new HelpScreen3(game));
                    if(Settings.soundEnabled)
                        Assets.click.play(1);
                    return;
                }
            }
        }
    }
    @Override
    public void present (float deltatime){
        Graphics g = game.getGraphics();
        g.drawPixmap(Assets.background,0,0);
        g.drawPixmap(Assets.help2, 64 , 100);
        g.drawPixmap(Assets.buttons,256,416, 0, 64, 64, 64);
    }

    @Override
    public void pause(){

    }
    @Override
    public void resume(){

    }
    @Override
    public void dispose(){

    }

}
