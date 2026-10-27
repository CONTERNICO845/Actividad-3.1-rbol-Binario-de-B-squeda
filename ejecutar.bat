@echo off
setlocal

set "ROOT=%~dp0"
set "SRC=%ROOT%src"
set "BUILD=%ROOT%build"

if not exist "%BUILD%" mkdir "%BUILD%"

echo Compilando clases...
javac -encoding UTF-8 -d "%BUILD%" "%SRC%\back_end\Empleado.java" "%SRC%\back_end\NodoABB.java" "%SRC%\back_end\ArbolBusqueda.java" "%SRC%\front_end\Main.java" "%SRC%\front_end\VentanaPrincipal.java" "%SRC%\front_end\VistaArbolPanel.java"
if errorlevel 1 (
    echo.
    echo Ocurrio un error al compilar. Verifica que el JDK este instalado y en el PATH.
    pause
    exit /b 1
)

echo Iniciando aplicacion...
java -cp "%BUILD%" front_end.Main

endlocal
