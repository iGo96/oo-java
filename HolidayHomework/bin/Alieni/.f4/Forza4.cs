using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using PlayersUnit;
using GridGameUnit;

namespace Forza4
{
    public enum TResultF4 { rF4Win, rF4Tie, rF4Playing, rF4Error }; 

    class TForza4
    {
        
        private static int _DefaultnPlayers = 2;
 
        public TGridF4 GridF4;
        public TPlayers Players;
        private bool _IsPlaying;
        private int _CurPlayer;
        
        public TForza4()
        {
            GridF4 = new TGridF4();
            Players = new TPlayers(_DefaultnPlayers);
            _IsPlaying = false;  
            _CurPlayer = -1;
            
        }

        public TForza4(int row, int col, int nPlayers, int toWin)
        {
            GridF4 = new TGridF4(row, col, toWin);
            Players = new TPlayers(nPlayers);
            _IsPlaying = false;
            _CurPlayer = -1;
        }

        public void StartGame(int p)
        {
            GridF4.Reset();
            _IsPlaying = true;
            _CurPlayer = p;
        }

        public void ResetScores()
        {
            Players.ResetScores();
        }

        public int CurPlayer
        {
            get { return _CurPlayer; }
        }

        public bool IsPlaying
        {
            get { return _IsPlaying; }
        }

        public TResultF4 Play(int col, ref int r)
        {
            TResultF4 retVal = TResultF4.rF4Error;
            r = -1;

            if ((_IsPlaying) && (GridF4.CheckCol(col)) && !GridF4.IsColFull(col))
            {
                r = GridF4.SetPlayer(col, _CurPlayer);

                if (GridF4.ThereIsWinner(r, col))
                {
                    retVal = TResultF4.rF4Win;
                    _IsPlaying = false;
                    Players.UpdateWinsLossScores(_CurPlayer);
	            }
                else if (GridF4.IsTieMatch())
               {
                   retVal = TResultF4.rF4Tie;
                    _IsPlaying = false;
                    Players.UpdateTieScores();
	            } 
                else
                {
                    _CurPlayer = (_CurPlayer + 1) % Players.nPlayers;
                } 
            }
            return retVal;
        }

    }
}
