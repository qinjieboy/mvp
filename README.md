# mvp
深入理解MVP概念
## mvp login 

相信大家对MVC都是比较熟悉了：M-Model-模型、V-View-视图、C-Controller-控制器，MVP作为MVC的演化版本，那么类似的MVP所对应的意义：M-Model-模型、V-View-视图、P-Presenter-表示器。 从MVC和MVP两者结合来看，Controlller/Presenter在MVC/MVP中都起着逻辑控制处理的角色，起着控制各业务流程的作用。而 MVP与MVC最不同的一点是M与V是不直接关联的也是就Model与View不存在直接关系，这两者之间间隔着的是Presenter层，其负责调控 View与Model之间的间接交互。在 Android中很重要的一点就是对UI的操作基本上需要异步进行也就是在MainThread中才能操作UI，所以对View与Model的切断分离是 合理的。<br> 
此外Presenter与View、Model的交互使用接口定义交互操作可以进一步达到松耦合也可以通过接口更加方便地进行单元测试。


![](https://github.com/qinjieboy/mvp/raw/master/mvp.png)  


