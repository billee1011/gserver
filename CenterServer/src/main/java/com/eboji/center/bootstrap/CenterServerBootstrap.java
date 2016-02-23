package com.eboji.center.bootstrap;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;

import com.eboji.center.util.ConfigUtil;

/**
 * 代理服务启动的入口类
 * @author zhoucl 2016-02-19
 */
public class CenterServerBootstrap {
	private static final Logger logger = LoggerFactory.getLogger(CenterServerBootstrap.class);
	
	private static final Daemon daemon = Daemon.getInstance();
	
	private static Boolean DEBUG = true;
	
	static {
		try {
			ShutdownHook.doShutdownHook();
			
			/**
			 * 读取conf文件夹中的logback.xml配置文件
			 */
			if(!DEBUG) {
				String jarPath = CenterServerBootstrap.class.getProtectionDomain().getCodeSource().getLocation().getFile();
				jarPath = jarPath.substring(0, jarPath.lastIndexOf('/'));
				jarPath = jarPath.substring(0, jarPath.lastIndexOf('/') + 1) + "conf";
				File logbackFile = new File(jarPath + "/logback.xml");
				
				if (logbackFile.exists()) {
		            LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		            JoranConfigurator configurator = new JoranConfigurator();
		            configurator.setContext(lc);
		            lc.reset();
		            try {
		                configurator.doConfigure(logbackFile);
		            }
		            catch (JoranException e) {
		                e.printStackTrace(System.err);
		                System.exit(-1);
		            }
		        }
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
			System.exit(-1);
		}
	}
	
	public static void main(String[] args) {
		DEBUG = Boolean.valueOf(System.getProperty("debug", "true"));
		
		try {
			if(DEBUG) {
				loadProps(DEBUG);
				
				daemon.init();
				daemon.start();
			} else {
				checkArgs(args);
				String command = "start";
				if(args.length > 0) {
					command = args[args.length - 1];
				}
				
				if(command.equals("start")) {
					daemon.init();
					daemon.start();
				} else if(command.equals("stop")) {
					daemon.stop();
				} else {
					logger.warn("Bootstrap: command \"" + command + "\" does not exist.");
				}
			}
		} catch (Exception e) {
			logger.error("Center Server started fail!", e);
			System.exit(-1);
		}
	}
	
	private static void checkArgs(String[] args) {
		try {
			for (int i = 0; i < args.length; ++i) {
				if (args[i].startsWith("--port")) {
					daemon.setPort(Integer.valueOf(args[i].split("=")[1]));
				} else if (args[i].equals("--timeout")) {
					
				} else if (args[i].equals("--ssl")) {
					
				} else if (args[i].equals("--help")) {
					System.out.println("Allowed options:");
					System.out.println("  --help\t\t\tProduce help message");
					System.out.println("  --port=arg (=" + daemon.getPort() + ")\t\tPort number to connect");
//					System.out.println("  --transport=arg (=" + daemon.getTransport_type() + ")\tTransport: buffered, framed, fastframed, http");
//					System.out.println("  --protocol=arg (=" + daemon.getProtocol_type() + ")\tProtocol: binary, json, compact");
//					System.out.println("  --ssl\t\t\t\tEncrypted Transport using SSL");
//					System.out.println("  --server-type=arg (=" + daemon.getServer_type() +")\n\t\t\t\tType of server: simple, nonblocking, hsha, threaded-selector, thread-pool");
					System.exit(0);
				}
			}
		} catch (Exception x) {
			logger.error("Can not parse arguments! See --help");
			System.exit(-1);
		}
	}
	
	private static void loadProps(Boolean isDebug) {
		String filePath = "";
		FileInputStream fis = null;
		
		try {
			if(DEBUG) {
				filePath = CenterServerBootstrap.class.getClass().getResource("/").getPath() + "config.properties";
			} else {
				String jarPath = CenterServerBootstrap.class.getProtectionDomain().getCodeSource().getLocation().getFile();
				jarPath = jarPath.substring(0, jarPath.lastIndexOf('/'));
				jarPath = jarPath.substring(0, jarPath.lastIndexOf('/') + 1) + "conf";
				filePath = jarPath + "/config.properties";
			}
			
			logger.info("Load config file: "  + filePath + " success!");
			fis = new FileInputStream(new File(filePath));
			
			Properties p = new Properties();
			p.load(fis);
			
			ConfigUtil.setProps(p);
		} catch (Exception e) {
			logger.error("Load config file: " + filePath + " exception:\n" + e.getMessage());
		}
	}
}
