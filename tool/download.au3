Sleep(3000);
Local $handle = WinGetHandle("[CLASS:MozillaDialogClass]");

While 1   
if  @error Then
    Sleep(3000);
    $handle = WinGetHandle("[CLASS:MozillaDialogClass]");
 Else
	ExitLoop;
 EndIf
WEnd
WinActivate("[CLASS:MozillaDialogClass]");
Send("{DOWN}");
Send("{ENTER}");
