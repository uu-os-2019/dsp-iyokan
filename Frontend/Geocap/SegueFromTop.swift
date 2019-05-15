//
//  SegueFromTop.swift
//  Geocap
//
//  Created by Erik Hellström on 2019-05-09.
//  Copyright © 2019 Oscar Englöf. All rights reserved.
//

import UIKit

class SegueFromTop: UIStoryboardSegue {
        override func perform() {
            let src = self.source as UIViewController
            let dst = self.destination as UIViewController
            
            dst.view.superview?.sendSubview(toBack: src.view)
            src.view.transform = CGAffineTransform(translationX: 0, y: src.view.frame.size.height)
            
            UIView.animate(withDuration: 0.75, animations: {
                src.view.transform = CGAffineTransform(translationX: 0, y: 0)
                
            }) { (Finished) in
                src.present(dst, animated: false, completion: nil)
            }
        }
}
