@echo off
cd mcp

rem this removes forestry but allows me to keep it in my sourcecode for future use
rem del reobf\minecraft\bstramke\NetherStuffs\PluginForestry.class

mkdir reobf\minecraft\bstramke\TEOreGenBase
mkdir reobf\minecraft\bstramke\TEOreGenBase\bstramke

move reobf\minecraft\bstramke\TEOreGenBase reobf\minecraft\bstramke\TEOreGenBase\bstramke

mkdir reobf\minecraft\bstramke\TEOreGenBase\assets
xcopy src\minecraft\assets\teoregen reobf\minecraft\bstramke\TEOreGenBase\assets\teoregen\ /S



copy src\minecraft\bstramke\TEOreGen\mcmod.info reobf\minecraft\bstramke\TEOreGenBase\mcmod.info

cd reobf\minecraft\bstramke\TEOreGenBase
"C:\Program Files\7-Zip\7z.exe" a -tzip mod_TEOreGen.zip *
cd D:\GitHub\TEOreGen
copy mcp\reobf\minecraft\bstramke\TEOreGenBase\mod_TEOreGen.zip mod_TEOreGen.jar
pause