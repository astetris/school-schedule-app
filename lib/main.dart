import 'package:flutter/material.dart';
import 'package:firebase_core/firebase_core.dart';
import 'screens/home_screen.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  // Firebaseの初期化設定（後ほどfirebase_optionsを生成して有効化します）
  // await Firebase.initializeApp();
  runApp(const JikanwariProApp());
}

class JikanwariProApp extends StatelessWidget {
  const JikanwariProApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: '時間割プロ',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(
          seedColor: const Color(0xFF4F46E5),
          primary: const Color(0xFF4F46E5),
        ),
        useMaterial3: true,
      ),
      home: const HomeScreen(),
    );
  }
}
