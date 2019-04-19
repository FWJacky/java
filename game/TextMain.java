package com.bit.game;

/**
 * @ClassName TextMain
 * @Description TODO
 * @Author L
 * @Date 2019/4/6 14:47
 * @Version 1.0
 **/
public class TextMain {
    public static void main(String[] args) {
        Game game = new Game();
        System.out.println("===========欢迎来到猜拳游戏============");
        System.out.println("游戏规则：三局两胜，每局统计分数，判断"+'\n'+
                "哪一方获胜，三局过后，得到最终胜利玩家"+'\n'+"最后可以选择继续和结束游戏");
        System.out.println("=====================================");
        game.start();
    }
}
