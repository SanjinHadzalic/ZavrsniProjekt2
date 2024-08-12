import { ApplicationConfig, importProvidersFrom } from '@angular/core';
import { provideRouter } from '@angular/router';
import { provideHttpClient, withInterceptors } from '@angular/common/http';

import { routes } from './app.routes';
import { authInterceptor } from './interceptors/auth.interceptor';
import { refreshInterceptor } from './interceptors/refresh.interceptor';
import { TranslateModule } from '@ngx-translate/core';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { provideTranslation } from './translate-loader';

export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes),
    provideHttpClient(),
    provideHttpClient(
      withInterceptors([authInterceptor /*,refreshInterceptor*/])
    ), importProvidersFrom(TranslateModule.forRoot(provideTranslation())),
    provideAnimationsAsync(),
    provideAnimationsAsync(),
  ],
};
