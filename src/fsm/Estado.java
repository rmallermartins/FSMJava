package fsm;

public interface Estado {
	
	Estado next(char simbolo);
	
}