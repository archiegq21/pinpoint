import UIKit
import SwiftUI
import shared

struct PinPointView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        PinPointViewControllerKt.PinPointAppController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ContentView: View {
    var body: some View {
        PinPointView()
            .frame(maxWidth: .infinity, maxHeight: .infinity)
            .ignoresSafeArea(.all)
    }
}



