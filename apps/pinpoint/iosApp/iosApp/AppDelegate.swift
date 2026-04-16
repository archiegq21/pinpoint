import Foundation
import UIKit
import FirebaseCore
import shared

class AppDelegate: NSObject, UIApplicationDelegate,
                   UNUserNotificationCenterDelegate {

    func application(_ application: UIApplication,
                     didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey : Any]? = nil) -> Bool {
        FirebaseApp.configure()
        LogUtilKt.startKermit()
        return true
    }

}
