using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using CellUnit;
using PlayersUnit;

namespace GridGameUnit
{
    // la matrice non sa che si gioca a F4 quindi
    // - la riga zero è proprio la riga zero
    // - non sa quanti giocatori ci siano
    // - non sa come inserire una pedina
    // - non sa come trovare una vincita

    class TGridGame
    {
        private static int _DefaultRow = 10;
        private static int _DefaultCol = 10;

        protected TCell[,] _Cells;
        private int _nRow;
        private int _nCol;
       
        public TGridGame()
        {
            _nRow = _DefaultRow;
            _nCol = _DefaultCol;
            _Cells = new TCell[_nRow, _nCol]; 
            
            for (int r = 0; r < _nRow; r++)
                for (int c = 0; c < _nCol; c++)
                    _Cells[r, c] = new TCell();
        }

        public TGridGame(int rows, int cols)  // se unod dei due parametri vale zero, devo fare eseguire un eccezione
        {
            _nRow = rows;
            _nCol = cols;
            _Cells = new TCell[_nRow, _nCol]; 
            
            for (int r = 0; r < _nRow; r++)
                for (int c = 0; c < _nCol; c++)
                    _Cells[r, c] = new TCell();
        }

        public void Reset()
        {
            for (int r = 0; r < _nRow; r++)
            {
                for (int c = 0; c < _nCol; c++)
                {
                    _Cells[r, c].Reset();
                }
            }
        }
 
        public int nRow
        {
            get { return _nRow; }
        }

        public int nCol
        {
            get { return _nCol; }
        }

        public int GetPlayer(int row, int col) 
        {
            int retVal = -1;
            if (!_Cells[row, col].IsEmpty())
                retVal = _Cells[row, col].Player;
            return retVal;
        }

        public bool IsEmpty(int row, int col)
        {
            return _Cells[row, col].IsEmpty();
        }

        public bool IsColFull(int col) // non controllo se col è accettabile..lascio che si generi un errore
        {
            bool retVal = true;

            int r =0;
            do
            {
                retVal = (retVal && !_Cells[r, col].IsEmpty());
                r++;
            } while ((r < _nRow) && retVal);

            return retVal;  
        }

        public int GetFirstFreeRow(int col) // torna -1 se non c'è
        {
            int retVal = -1;

            if (CheckCol(col))
            {
                int r = 0;
                do
                {
                    if (_Cells[r, col].IsEmpty())
                        r++;
                    else
                        return retVal = r;  
                } while ((r < _nRow) && (retVal == -1));
            }

            return retVal;
        }

        public bool IsFull() 
        {
            bool retVal = true;

            int c = 0;
            do
            { 
                retVal = retVal && IsColFull(c);
                c++;
            } while ((c < _nCol) && (retVal));

            return retVal;
        }

        public bool CheckRow(int r)
        {
            return ((r >= 0) && (r < _nRow));
        }

        public bool CheckCol(int c)
        {
            return ((c >= 0) && (c < _nCol));
        }
        
        protected int NearbyVertical(int r, int c)  
        {
            int count = 0;
            
            int i;
            i = r+1;
            while( (i < _nRow ) && (_Cells[i,c].Player == _Cells[r,c].Player) ) 
            {
                count++;
                i++;
            }

            i = r-1;
            while( (i >= 0) && (_Cells[i,c].Player == _Cells[r,c].Player) ) 
            {
                count++;
                i--;
            }
            return count;
        }

        protected int NearbyOrizontal(int r, int c)
        {
            int count = 0;

            int j = c+1;
            while( (j < _nCol ) && (_Cells[r,j].Player == _Cells[r,c].Player) ) 
            {
                count++;
                j++;
            }

            j = c-1;
            while( (j >= 0 ) && (_Cells[r,j].Player == _Cells[r,c].Player) ) 
            {
                count++;
                j--;
            }
            return count;
        }

        protected int NearbyDiagonalUpDown(int r, int c)
        {
            int count = 0;

            int i = r+1; int j = c+1;
            while( (i < _nRow) && (j < _nCol ) &&  (_Cells[i,j].Player == _Cells[r,c].Player)) 
            {
                count++;
                i++;
                j++;
            }

            i = r-1; j = c-1;
            while( (i >= 0 ) &&  (j >= 0) && (_Cells[i,j].Player == _Cells[r,c].Player)) 
            {
                count++;
                i--;
                j--;
            }
            return count;
        }

        protected int NearbyDiagonalDownUp(int r, int c)
        {
            int count = 0;

            int i = r-1; int j = c+1;
            while( (i >= 0) && (j < _nCol ) &&  (_Cells[i,j].Player == _Cells[r,c].Player)) 
            {
                count++;
                i--;
                j++;
            }

            i = r+1; j = c-1;
            while( (i < _nRow ) &&  (j >= 0) && (_Cells[i,j].Player == _Cells[r,c].Player)) 
            {
                count++;
                i++;
                j--;
            }
            return count;
        }
    }

    class TGridF4 : TGridGame
    {
        // la matrice  sa che si gioca a F4 quindi
        // - la riga zero è corrisponde alla riga alta del gioco
        // - sa come inserire una pedina
        // - sa come trovare una vincita o pareggio

        private static int _DefaultRow = 6;
        private static int _DefaultCol = 7;
        private static int _DefaultToWin = 4;

        private int _nToWin;

        public TGridF4() :base(_DefaultRow, _DefaultCol) 
        {
            _nToWin = _DefaultToWin;
        }

        public TGridF4(int rows, int cols, int toWin) :base(rows, cols) 
        {
            _nToWin = toWin;
        }

        public int nToWin
        {
            get { return _nToWin; }
        }
        
        public new bool IsColFull(int col) // non controllo se col è accettabile..lascio che si generi un errore
        {
            return !(_Cells[0, col].IsEmpty());
        }

        public int SetPlayer(int col, int p) // torna -1 se non c'è una cella disponibile, alltrimenti torna la riga scelta
        {
            int retVal = -1;        

            if (!IsColFull(col))
            {
                int r = nRow - 1;

                do
                {
                    if (_Cells[r, col].IsEmpty())
                    {
                        _Cells[r, col].Player = p;
                        retVal = r;
                    }
                    else
                        r--;
                } while ((r >= 0) && (retVal==-1));
            }
            return retVal;
        }

        public bool ThereIsWinner(int row, int col) 
        {
            return ((NearbyVertical(row, col)+1) >= _nToWin) || ((NearbyOrizontal(row, col)+1) >= _nToWin) || ((NearbyDiagonalUpDown(row, col)+1) >= _nToWin) || ((NearbyDiagonalDownUp(row, col)+1) >= _nToWin); 
        }

        public bool IsTieMatch()
        {
            bool retVal = true;

            int c = 0;
            do
            {
                retVal = retVal && IsColFull(c);
                c++;
            } while ((c < nCol) && (retVal));

            return retVal;
        }

    }
}
