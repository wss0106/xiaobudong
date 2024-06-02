//package com.wss.xiaobudong.plugin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class PluginController {
//
//    private final PluginManager pluginManager;
//
//    public PluginController() {
//        this.pluginManager = new PluginManager();
//        // 初始化时加载插件
//        try {
//            pluginManager.loadPlugin("/path/to/plugin.jar", "com.example.MyPlugin");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @GetMapping("/process")
//    public String process(@RequestParam String input, @RequestParam String pluginName) {
//        Plugin plugin = pluginManager.getPlugin(pluginName);
//        return plugin != null ? plugin.process(input) : "Plugin not found";
//    }
//}
