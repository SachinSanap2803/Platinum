class findLock {
    public static void  main(String[] args) {
        boolean istrue = false;
        for(int i=0; i<999; i++) {
            if(i == 124) {
                istrue = true;
            }
        }
        System.out.println(istrue);
    }
}