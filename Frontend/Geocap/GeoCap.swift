//
//  GeoCap.swift
//  Geocap
//
//  Created by Benjamin Angeria on 2019-05-06.
//  Copyright © 2019 Oscar Englöf. All rights reserved.
//

import Foundation

class GeoCap {
    let server: Server
    let quizModel: QuizModel
    var currentLocation: String?
    var locations = [Location]()
    var profileInfo: ProfileInfo?
    
    init() {
        self.server = Server()
        self.quizModel = QuizModel()
    }
    
    func userHasLocations(location: String) -> Bool {
        let profileInfo = self.server.getProfileInfo()
        let locations = profileInfo!.locations!
        for userLocations in locations {
            print(location)
            print(userLocations)
            if(userLocations == location) {
                return true
            }
        }
        return false
    }

}
