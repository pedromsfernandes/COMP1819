class Lazysort extends Quicksort {
    public static void main(String[] a) {
        int[] L;
        int i;
        Quicksort q;
        boolean dummy;

        L = new int[10];

        i = 0;
        while (i < L.length) {
            L[i] = L.length - i;

            i = i + 1;
        }

        q = new Lazysort();

        dummy = q.quicksort(L);
        dummy = q.printL(L);
    }

    public boolean quicksort(int[] L) {
        boolean lazy;
        if ( MathUtils.random(0, 5) < 4 ) {
            this.beLazy(L);
            lazy = true;
        }
        else {
            lazy = false;
        }
        
        if ( lazy ) {
            lazy = !lazy;
        }
        else {
            lazy = this.quicksort(L, 0, L.length - 1);
        }
        
        return lazy;
    }
    
    public boolean beLazy(int[] L) {
        int _allowedNameL;
        int $allowedNameI;

        _allowedNameL = L.length;
        
        $allowedNameI = 0;
        while ($allowedNameI < _allowedNameL/2) {
            L[$allowedNameI] = MathUtils.random(0, 10);

            $allowedNameI = $allowedNameI + 1;
        }
        
        while ($allowedNameI < _allowedNameL) {
            L[$allowedNameI] = MathUtils.random(0, 10) + 1;

            $allowedNameI = $allowedNameI + 1;
        }        
        
        
        return true;
    }
}
