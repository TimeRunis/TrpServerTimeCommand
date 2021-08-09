# TrpServerTimeCommand
A Minecraft Server Plugin(一个我的世界服务器插件


这玩意可以记录三个数据（每分钟记录一次）


oneTime: 这个数据在服务器启动后会开始记录，如果重启服务器，它会被清空


allTime: 这个数据在本插件被安装后开始记录


dayTime: 这个数据在endTime(可以自定义)这个时间过去后会被清空


# config.yml
```
#插件的提示前缀
name: "&b[TrpServerTimeCommand]"

#每日在线时间清空的时间（请不要使用全角符号
endTime: "00:00"

#本项基于oneTime数据
timeTask:
#ID，请按照顺序命名
  1:
    #间隔时间/min
    time: 1
    #要执行的指令，%playerName%代表玩家名称
    command: "give %playerName% book 1"
    #发送给玩家的提示信息，%oneTimeMin%代表本次服务器启动后的在线时间单位为分钟
    message:  "&e你获得了一本书"

#本项基于dayTime数据
dayTimeTask:
  1:
    #间隔时间/min
    time: 1
    #要执行的指令，%playerName%代表玩家名称
    command: "give %playerName% book 1"
    #发送给玩家的提示信息，%dayTimeMin%代表本次服务器启动后的在线时间单位为分钟
    message: "&e你获得了一本书"

#本项基于allTime数据
allTimeTask:
  1:
    #间隔时间/min
    time: 1
    #要执行的指令，%playerName%代表玩家名称
    command: "give %playerName% book 1"
    #发送给玩家的提示信息，%allTimeMin%代表本次服务器启动后的在线时间单位为分钟
    message: "&e你获得了一本书"

dayTimeEvent:
  1:
    #达成条件/min
    time: 1
    #要执行的指令，%playerName%代表玩家名称
    command: "give %playerName% book 1"
    #发送给玩家的提示信息，%allTimeMin%代表本次服务器启动后的在线时间单位为分钟
    message: "&e你获得了一本书"
```
<br><br><br>


# English(unfinish)
This plugin can record 3 datas(be recorded per one minite)<br>

oneTime: It is recorded when the sevrer start.If the server restart,it will be emptied<br>
allTime: it is recorded when the plugin is installed<br>
dayTime: It is emptied when pass the endTime(can be customed)<br>


