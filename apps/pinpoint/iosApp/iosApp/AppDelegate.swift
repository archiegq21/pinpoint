import Foundation
import UIKit
import FirebaseCore
import GoogleSignIn
import GoogleMaps
import shared

class AppDelegate: NSObject, UIApplicationDelegate,
                   UNUserNotificationCenterDelegate {

    func application(_ application: UIApplication,
                     didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey : Any]? = nil) -> Bool {
        FirebaseApp.configure()
        LogUtilKt.startKermit()
        return true
    }

    func application(_ app: UIApplication, open url: URL, options: [UIApplication.OpenURLOptionsKey : Any] = [:]) -> Bool {
        var handled: Bool
                
        handled = GIDSignIn.sharedInstance.handle(url)
        
        if handled {
            return true
        }
        
        return false
    }
    
    
}
