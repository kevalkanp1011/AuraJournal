# AuraJournal 📔✨  
An AI-powered journaling app built with Kotlin Multiplatform to help users track their mood, record voice entries, and gain insights into their emotional well-being.

[![GitHub Repo](https://img.shields.io/badge/GitHub-Repo-blue?logo=github)](https://github.com/kevalkanp1011/AuraJournal)  
**Deliverables Link**: [Google Drive Folder](https://drive.google.com/drive/folders/19I_xt7b1kvBwK3bZDksbK2L6I5pPtBTm?usp=sharing)

---

## Features 🌟  
- Voice-to-text journal entries using **Grok AI** transcription.  
- Mood tracking with predefined tags.  
- Cross-platform support (Android/iOS) via **Kotlin Multiplatform**.  
- Modern UI built with **Jetpack Compose** (Android) and **SwiftUI** (iOS).  

---

## How We Built It 🛠️  
### Tech Stack & Libraries  
- **Kotlin Multiplatform**: Shared business logic across Android/iOS.  
- **Jetpack Compose**: Declarative UI for Android.  
- **Koin**: Dependency injection to manage components.  
- **Grok AI**: Speech-to-text transcription for voice entries.  
- **Ktor Client**: Networking for API calls to Grok AI.  

### Challenges  
- Real-time audio transcription requires an active internet connection.  
- Manual mood selection limits dynamic AI-driven insights.  

---

## Limitations ⚠️  
1. **Online-Only Transcription**: Voice entries cannot be processed offline.  
2. **Static Mood Options**: Users must select moods from a predefined list instead of AI-generated suggestions.  

---

## Roadmap 🗺️  
### Next Milestones  
1. **AI-Powered Mood Analysis**:  
   - Integrate **Grok AI** to auto-detect mood from voice/text entries weekly/monthly.  
2. **Visual Analytics**:  
   - Add charts/graphs to visualize mood trends and energy levels over time.  
3. **Personalized Suggestions**:  
   - Generate recommendations (e.g., meditation, workout) based on AI-derived mood scores.  
4. **Memory Summaries**:  
   - Create concise summaries of journal entries for selected time periods.  

---

## Getting Started 🚀  
1. Clone the repository:  
   ```bash  
   git clone https://github.com/kevalkanp1011/AuraJournal.git  
   ```  
2. Open in Android Studio or Xcode and build for your target platform.  
3. Replace Grok AI API keys (if needed) in the network module.  

---

**Deliverables**: Detailed documentation, screenshots, and videos are available in the [Google Drive Folder](https://drive.google.com/drive/folders/19I_xt7b1kvBwK3bZDksbK2L6I5pPtBTm?usp=sharing).  

---  
Built with ❤️ by [Keval Kanpariya](https://github.com/kevalkanp1011).  
Feedback and contributions welcome!
