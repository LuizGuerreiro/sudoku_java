public enum GameStatusEnum {
    
    NON_STARTED(" ||  Jogo não foi iniciado! ||"),
    INCOMPLETE(" ||  Jogo está incompleto!  ||"),
    COMPLETE(" ||   Jogo está completo!   ||");

    private String label;

    GameStatusEnum(final String label){
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}
