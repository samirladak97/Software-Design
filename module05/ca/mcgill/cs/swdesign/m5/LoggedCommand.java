package ca.mcgill.cs.swdesign.m5;

public class LoggedCommand implements Command
{
	private Command aCommand;
	private String aLog;
	
	public LoggedCommand(Command pCommand, String pLog) {
		aCommand = pCommand;
		aLog = pLog;
	}

	@Override
	public void execute()
	{
		aCommand.execute();
		System.out.println("Executed " + aLog);
		
	}

}
