//package com.wss.xiaobudong.plugin;
//import java.net.URL;
//import java.net.URLClassLoader;
//import java.util.HashMap;
//import java.util.Map;
//
//public class PluginManager {
//    private Map<String, Plugin> plugins = new HashMap<>();
//
//    public void loadPlugin(String jarPath, String className) throws Exception {
//        URL[] urls = {new URL("file:" + jarPath)};
//        URLClassLoader classLoader = new URLClassLoader(urls);
//        Class<?> clazz = classLoader.loadClass(className);
//        Plugin plugin = (Plugin) clazz.getDeclaredConstructor().newInstance();
//        plugins.put(className, plugin);
//    }
//
//    public Plugin getPlugin(String className) {
//        return plugins.get(className);
//    }
//}
