# TrpServerTimeCommand
A Minecraft Server Plugin(一个我的世界服务器插件


这玩意可以记录三个数据（每分钟记录一次）<br>

oneTime: 这个数据在服务器启动后会开始记录，如果重启服务器，它会被清空<br>
allTime: 这个数据在本插件被安装后开始记录<br>
dayTime: 这个数据在endTime(可以自定义)这个时间过去后会被清空<br>

# config.yml
```
#插件的提示前缀<br>
name: "&b[TrpServerTimeCommand]"<br>
<br>
#每日在线时间清空的时间（请不要使用全角符号<br>
endTime: "00:00"<br>
<br>
#本项基于oneTime数据<br>
timeTask:<br>
#ID，请按照顺序命名<br>
  1:<br>
    #间隔时间/min<br>
    time: 1<br>
    #要执行的指令，%playerName%代表玩家名称<br>
    command: "give %playerName% book 1"<br>
    #发送给玩家的提示信息，%oneTimeMin%代表本次服务器启动后的在线时间单位为分钟<br>
    message:  "&e你获得了一本书"<br>
<br>
#本项基于dayTime数据<br>
dayTimeTask:<br>
  1:<br>
    #间隔时间/min<br>
    time: 1<br>
    #要执行的指令，%playerName%代表玩家名称<br>
    command: "give %playerName% book 1"<br>
    #发送给玩家的提示信息，%dayTimeMin%代表本次服务器启动后的在线时间单位为分钟<br>
    message: "&e你获得了一本书"<br>
<br>
#本项基于allTime数据<br>
allTimeTask:<br>
  1:<br>
    #间隔时间/min<br>
    time: 1<br>
    #要执行的指令，%playerName%代表玩家名称<br>
    command: "give %playerName% book 1"<br>
    #发送给玩家的提示信息，%allTimeMin%代表本次服务器启动后的在线时间单位为分钟<br>
    message: "&e你获得了一本书"<br>
<br>
dayTimeEvent:<br>
  1:<br>
    #达成条件/min<br>
    time: 1<br>
    #要执行的指令，%playerName%代表玩家名称<br>
    command: "give %playerName% book 1"<br>
    #发送给玩家的提示信息，%allTimeMin%代表本次服务器启动后的在线时间单位为分钟<br>
    message: "&e你获得了一本书"<br>
<br>
```
<br><br><br>


# English(unfinish)
This plugin can record 3 datas(be recorded per one minite)<br>

oneTime: It is recorded when the sevrer start.If the server restart,it will be emptied<br>
allTime: it is recorded when the plugin is installed<br>
dayTime: It is emptied when pass the endTime(can be customed)<br>


