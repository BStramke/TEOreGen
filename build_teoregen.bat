@echo off
cd mcp
mkdir reobf\minecraft\bstramke\OresDropMores2Base
mkdir reobf\minecraft\bstramke\OresDropMores2Base\bstramke
move reobf\minecraft\bstramke\OresDropMores2 reobf\minecraft\bstramke\OresDropMores2Base\bstramke

rem mkdir reobf\minecraft\bstramke\OresDropMores2Base\bstramke\OresDropMores2\
rem mkdir reobf\minecraft\bstramke\OresDropMores2Base\bstramke\OresDropMores2\textures
rem mkdir reobf\minecraft\bstramke\OresDropMores2Base\bstramke\OresDropMores2\textures\icons

xcopy reobf\minecraft\forestry reobf\minecraft\bstramke\OresDropMores2Base\forestry\ /S
xcopy src\minecraft\assets reobf\minecraft\bstramke\OresDropMores2Base\assets\ /S

copy src\minecraft\bstramke\OresDropMores2\mcmod.info reobf\minecraft\bstramke\OresDropMores2Base\mcmod.info
rem copy src\minecraft\bstramke\OresDropMores2\resources\* reobf\minecraft\bstramke\OresDropMores2Base\bstramke\OresDropMores2\resources
rem copy src\minecraft\bstramke\OresDropMores2\resources\textures\* reobf\minecraft\bstramke\OresDropMores2Base\bstramke\OresDropMores2\resources\textures
rem copy src\minecraft\bstramke\OresDropMores2\resources\textures\gui\* reobf\minecraft\bstramke\OresDropMores2Base\bstramke\OresDropMores2\resources\textures\gui


cd reobf\minecraft\bstramke\OresDropMores2Base
"C:\Program Files\7-Zip\7z.exe" a -tzip mod_OresDropMores2.zip *
cd..
move OresDropMores2Base\mod_OresDropMores2.zip mod_OresDropMores2.zip
cd D:\GitHub\OresDropMores2
copy mcp\reobf\minecraft\bstramke\mod_OresDropMores2.zip mod_OresDropMores2.jar
pause