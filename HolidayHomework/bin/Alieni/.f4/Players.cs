using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace PlayersUnit
{
    class TPlayer
    {
        private string _Name;
        private int _Wins;
        private int _Games;
        private int _Losses;

        public TPlayer()
        {
            _Name = "Unknow";
            _Wins = 0;
            _Games = 0;
            _Losses = 0;
        }

        public TPlayer(string n)
        {
            _Name = n;
            _Wins = 0;
            _Games = 0;
            _Losses = 0;
        }

        
        public void ResetScores()  
        {
            _Wins = 0;
            _Games = 0;
            _Losses = 0;
        }

        public string Name
        {
            get { return _Name; }
            set
            {
                if (value == string.Empty)
                    _Name = "Unknow";
                else
                    _Name = value;
            }
        }

        public int Wins
        {
            get { return _Wins; }
        }

        public int Games
        {
            get { return _Games; }
        }

        public int Losses
        {
            get { return _Losses; }
        }

        public void UpdateWinnerScores()
        {
            _Wins++;
            _Games++;
        }

        public void UpdateLoserScores()
        {
            _Losses++;
            _Games++;
        }

        public void UpdateTieScores()
        {
            _Games++;
        }
    }

    class TPlayers
    {
        private static int DefaultNumPlayers = 2; 

        private TPlayer[] _Items;   
        private int _nPlayers;

        public TPlayers()
        {
            _nPlayers = DefaultNumPlayers;  
            _Items = new TPlayer[_nPlayers]; 

            for (int i = 0; i < _nPlayers; i++)
                _Items[i] = new TPlayer("Player " + (i + 1).ToString()); 
        }

        public TPlayers(int n)
        {
            _nPlayers = n;
            _Items = new TPlayer[_nPlayers];  

            for (int i = 0; i < _nPlayers; i++)
                _Items[i] = new TPlayer("Player " + (i + 1).ToString());
        }
        
        public void ResetScores()  
        {
            for (int i = 0; i < _nPlayers; i++)
                _Items[i].ResetScores();
        }

        public string Name( int p) 
        {
            return _Items[p].Name;
        }

        public int NumWins(int p)
        {
            return _Items[p].Wins;
        }

        public int NumGames(int p)
        {
            return _Items[p].Games;
        }

        public int NumLosses(int p)
        {
            return _Items[p].Losses;
        }

        public void SetName(int p, string n)
        {
            _Items[p].Name = n;
        }

        public void UpdateWinsLossScores(int p)
        {
            for (int i = 0; i < _nPlayers; i++)
            {
                if (i == p)
                    _Items[i].UpdateWinnerScores();
                else
                    _Items[i].UpdateLoserScores();
            }
         }

        
        public void UpdateTieScores()
        {
            for (int i = 0; i < _nPlayers; i++)
            {
                _Items[i].UpdateTieScores();
            } 
        }

        public int nPlayers
        {
            get { return _nPlayers; }
            // set ...non è possibile modificare il numero di giocatori in corsa
        }
    }
}
