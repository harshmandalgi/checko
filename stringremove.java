class stringremove {

     

    public static void main(String[] args) {

        String master = "klsdjfh.java";

        String to_remove=".java";

         

        String new_string = master.replace(to_remove, "");

        // the above line replaces the t_remove string with blank string in master

         

        System.out.println(master);

        System.out.println(new_string);

         

    }

}

