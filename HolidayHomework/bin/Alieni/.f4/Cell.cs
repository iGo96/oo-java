using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace CellUnit
{
    class TCell
    {
        private int _Player;
        
        public TCell()
        {
            _Player = -1;
        }

        public void Reset()
        {
            _Player = -1;
        }

        public int Player
        {
            get { return _Player; }
            set { if ((IsEmpty()) && (value >= 0))
                   _Player = value; }  
        }

        public bool IsEmpty() 
        {
            return (_Player == -1);
        }

    }
}
