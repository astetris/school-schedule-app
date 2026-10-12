import 'package:home_widget/home_widget.dart';

Future<void> updateHomeScreenWidget(String title, String scheduleSummary) async {
  await HomeWidget.saveWidgetData<String>('widget_title', title);
  await HomeWidget.saveWidgetData<String>('widget_content', scheduleSummary);

  await HomeWidget.updateWidget(
    name: 'ScheduleWidgetProvider',
    androidName: 'ScheduleWidgetProvider',
  );
}
