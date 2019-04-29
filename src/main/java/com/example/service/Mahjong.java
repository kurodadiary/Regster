package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.mahjong4j.HandsOverFlowException;
import org.mahjong4j.IllegalMentsuSizeException;
import org.mahjong4j.MahjongTileOverFlowException;
import org.mahjong4j.hands.Kantsu;
import org.mahjong4j.hands.Kotsu;
import org.mahjong4j.hands.MahjongHands;
import org.mahjong4j.hands.MahjongMentsu;
import org.mahjong4j.hands.Shuntsu;
import org.mahjong4j.tile.MahjongTile;

public class Mahjong {

	public class sample {

	}

	public void sample() throws HandsOverFlowException, MahjongTileOverFlowException, IllegalMentsuSizeException{
        int[] tiles = {
                0, 1, 1, 1, 0, 0, 0, 0, 3,
                0, 0, 0, 0, 0, 0, 0, 0, 3,
                0, 0, 2, 0, 0, 0, 0, 0, 3,
                0, 0, 0, 0,
                0, 0, 0
            };
            MahjongTile last = MahjongTile.M6;
            MahjongHands hands = new MahjongHands(tiles, last);
            if (hands.getCanWin()) {
                System.out.println("和了の形です");
            } else {
              System.out.println("和了の形ではありません");
            }
	}

}
